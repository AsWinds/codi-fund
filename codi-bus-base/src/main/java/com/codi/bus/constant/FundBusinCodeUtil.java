package com.codi.bus.constant;

public class FundBusinCodeUtil {
	
	public static boolean isT0Sell(String fundBusinCode){
		return GlobalConstant.FUND_BUSIN_CODE_T0_FAST_APPLY_SELL.equals(fundBusinCode);
	}
	
	public static boolean isNormalSell(String fundBusinCode){
		return GlobalConstant.FUND_BUSIN_CODE_APPLY_SELL.equals(fundBusinCode) ||
				GlobalConstant.FUND_BUSIN_CODE_APPLY_FIX_SELL.equals(fundBusinCode);
	}
	
	public static boolean isBuy(String fundBusinCode){
		return GlobalConstant.FUND_BUSIN_CODE_APPLY_BUY.equals(fundBusinCode)
				|| GlobalConstant.FUND_BUSIN_CODE_APPLY_FIX_BUY.equals(fundBusinCode);
	}
	
	public static boolean isSell(String fundBusinCode){
		return GlobalConstant.FUND_BUSIN_CODE_APPLY_SELL.equals(fundBusinCode) ||
				GlobalConstant.FUND_BUSIN_CODE_T0_FAST_APPLY_SELL.equals(fundBusinCode) ||
				GlobalConstant.FUND_BUSIN_CODE_APPLY_FIX_SELL.equals(fundBusinCode);
	}
	
    /**
     * 是否是定投申购
     * 
     * @return
     */
    public static boolean isFixBuy(String fundBusinCode) {
        if (fundBusinCode.equals(GlobalConstant.FUND_BUSIN_CODE_APPLY_FIX_BUY)
                || fundBusinCode.equals(GlobalConstant.FUND_BUSIN_CODE_APPLY_FIX_BUY_SIGN)
                || fundBusinCode.equals(GlobalConstant.FUND_BUSIN_CODE_APPLY_FIX_BUY_CANCEL)
                || fundBusinCode.equals(GlobalConstant.FUND_BUSIN_CODE_APPLY_FIX_BUY_MODIFY)) {
            return true;
        }
        return false;
    }

    /**
     * 是否是定投赎回
     * 
     * @return
     */
    public static boolean isFixSell(String fundBusinCode) {
        if (fundBusinCode.equals(GlobalConstant.FUND_BUSIN_CODE_APPLY_FIX_SELL)
                || fundBusinCode.equals(GlobalConstant.FUND_BUSIN_CODE_APPLY_FIX_SELL_SIGN)
                || fundBusinCode.equals(GlobalConstant.FUND_BUSIN_CODE_APPLY_FIX_SELL_CANCEL)
                || fundBusinCode.equals(GlobalConstant.FUND_BUSIN_CODE_APPLY_FIX_SELL_MODIFY)) {
            return true;
        }
        return false;
    }
}
