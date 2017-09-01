package com.codi.api.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codi.base.config.ConfigurationMgr;
import com.codi.base.log.annotation.Loggable;
import com.codi.base.web.ResponseUtils;
import com.codi.bus.core.domain.AppVersionInfo;
import com.codi.bus.core.service.AppVersionInfoService;
import com.codi.bus.util.Platform;

@Controller
@RequestMapping("/app_version")
public class AppVersionInfoController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AppVersionInfoController.class);
	
	private String auth_user;
	private String auth_passwd;
	
	@Resource
	private AppVersionInfoService appVersionInfoService;
	
	public AppVersionInfoController() {
		ConfigurationMgr configMgr = ConfigurationMgr.getInstance();
		this.auth_user = configMgr.getString("app.version.auth.user", "codi_admin");
		this.auth_passwd = configMgr.getString("app.version.auth.passwd", "codi_admin_app_pass");
	}
	
	private boolean validateRequest(HttpServletRequest request, HttpServletResponse response){
		boolean result = false;
		try {
			String authorization = request.getHeader("Authorization");
			if (authorization == null) {
				result = false;
			}else{
				authorization = authorization.substring(6, authorization.length());
				String origin_val = new String(Base64.decodeBase64(authorization), StandardCharsets.UTF_8);
				String[] subs = origin_val.split(":");
				String name = subs[0], password = subs[1];
				if (auth_user.equals(name) && auth_passwd.equals(password)) {
					result = true;
				}
			}
		} catch (Exception e) {
			result = false;
		}
		if (result) {
			return result;
		}else{
			response.setStatus(401);
			return false;
		}
	}
	
	private void return401(HttpServletRequest request, HttpServletResponse response){
		response.setStatus(401);
		response.setHeader("WWW-Authenticate", "Basic realm=\".\"");
		try {
			response.getWriter().write("Auth before operate.");
		} catch (IOException e) {
			LOGGER.warn("Unexpectd error during get servlet output writer", e);
		}
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addVersionInfo(HttpServletRequest request, HttpServletResponse response, @Valid AppVersionInfo info){
		if (validateRequest(request, response)) {
			ResponseUtils.renderJson(request, response, appVersionInfoService.add(info), true);
		}else{
			return401(request, response);
		}
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void updateVersionInfo(HttpServletRequest request, HttpServletResponse response, @Valid AppVersionInfo info){
		if (validateRequest(request, response)) {
			ResponseUtils.renderJson(request, response, appVersionInfoService.update(info), true);
		}else{
			return401(request, response);
		}
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void deleteVersionInfo(HttpServletRequest request, HttpServletResponse response, Long id){
		if (validateRequest(request, response)) {
			ResponseUtils.renderJson(request, response, appVersionInfoService.delete(id), true);
		}else{
			return401(request, response);
		}
	}
	
	@RequestMapping(value = "/query_versions", method = RequestMethod.GET)
	public void queryAppVersions(HttpServletRequest request, HttpServletResponse response){
		if (validateRequest(request, response)) {
			ResponseUtils.renderJson(request, response, appVersionInfoService.getAll(), true);	
		}else{
			return401(request, response);
		}
	}
	
	@RequestMapping(value = "/query_versions_json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Loggable
	public ResponseEntity<?> queryAppVersionsJson(HttpServletRequest request, HttpServletResponse response){
		if (validateRequest(request, response)) {
			return new ResponseEntity<>(appVersionInfoService.getAll(), HttpStatus.OK);
		}else{
			return401(request, response);
			return null;
		}
	}
	
	@RequestMapping(value = "/query_version_after")
	public void queryAppVersionsAfter(HttpServletRequest request, HttpServletResponse response,
			@RequestParam String appIdentifier, @RequestParam Platform platform, @RequestParam String version){
		if (validateRequest(request, response)) {
			ResponseUtils.renderJson(request, response, appVersionInfoService.queryAppVersionsAfter(appIdentifier, platform, version), true);	
		}else{
			return401(request, response);
		}
	}
	
	@RequestMapping(value = "/latest", method = RequestMethod.GET)
	public void getLatestVersion(HttpServletRequest request, HttpServletResponse response,
			@RequestParam String appIdentifier, @RequestParam Platform platform){
		if (validateRequest(request, response)) {
			ResponseUtils.renderJson(request, response, appVersionInfoService.getNewestVersion(appIdentifier, platform), false);
		}else{
			return401(request, response);
		}
	}
		
}
