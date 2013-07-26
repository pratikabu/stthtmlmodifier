package com.pratikabu.scrolltotop.utils;


public class HtmlModifierDispatcher {
	public static final String T_MODIFY_FIREFOX_OPTIONS = "MFO",
			T_OPERA_CHROMIUM_OPTIONS_JS_IMPL = "OCOJI",
			T_OPERA_STT_JS_EXPANDING = "OSJE",
			T_XML_MODIFER = "XMOD";
	
	public static void main(String[] args) throws Exception {
		if(T_MODIFY_FIREFOX_OPTIONS.equals(args[0])) {
			FirefoxHtmlModifier.processHtml(args[1], args[2]);
		} else if(T_OPERA_CHROMIUM_OPTIONS_JS_IMPL.equals(args[0])) {
			OperaChromiumJSModifer.processJS(args[1], args[2]);
		} else if(T_OPERA_STT_JS_EXPANDING.equals(args[0])) {
			OperaSTTJSModifer.processJS(args[1]);
		} else if(T_XML_MODIFER.equals(args[0])) {
			GenericXMLModifier.modifyTagValue(args[1], args[2], args[3]);
		}
	}
	
}
