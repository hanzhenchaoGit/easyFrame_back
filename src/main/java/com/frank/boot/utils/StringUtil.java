
package com.frank.boot.utils;
 
 import java.math.BigDecimal;
 import java.text.DecimalFormat;
 import java.text.NumberFormat;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Locale;
 import java.util.StringTokenizer;
 
 

 public class StringUtil
 {
   public static boolean isNull(String obj)
   {
/*  21 */     return (obj == null) || (obj.equals(""));
   }
   
   public static boolean isNotNull(String obj) {
/*  25 */     return !isNull(obj);
   }
   
 
 
 
 
 
   public static String formatValue(double price)
   {
/*  35 */     NumberFormat nf = NumberFormat.getInstance(Locale.CHINESE);
/*  36 */     DecimalFormat df = (DecimalFormat)nf;
/*  37 */     df.setMinimumFractionDigits(2);
/*  38 */     df.setMaximumFractionDigits(2);
/*  39 */     String pattern = "#0.00";
/*  40 */     df.applyPattern(pattern);
/*  41 */     df.setDecimalSeparatorAlwaysShown(true);
/*  42 */     return df.format(price);
   }
   
 
 
 
 
 
   public static String formatValue4(double price)
   {
/*  52 */     NumberFormat nf = NumberFormat.getInstance(Locale.CHINESE);
/*  53 */     DecimalFormat df = (DecimalFormat)nf;
/*  54 */     df.setMinimumFractionDigits(4);
/*  55 */     df.setMaximumFractionDigits(4);
/*  56 */     String pattern = "#0.0000";
/*  57 */     df.applyPattern(pattern);
/*  58 */     df.setDecimalSeparatorAlwaysShown(true);
/*  59 */     return df.format(price);
   }
   
 
 
 
 
 
   public static String formatValue3(double price)
   {
/*  69 */     NumberFormat nf = NumberFormat.getInstance(Locale.CHINESE);
/*  70 */     DecimalFormat df = (DecimalFormat)nf;
/*  71 */     df.setMinimumFractionDigits(3);
/*  72 */     df.setMaximumFractionDigits(3);
/*  73 */     String pattern = "#0.000";
/*  74 */     df.applyPattern(pattern);
/*  75 */     df.setDecimalSeparatorAlwaysShown(true);
/*  76 */     return df.format(price);
   }
   
 
 
 
 
 
   public static String formatValue(String price)
   {
/*  86 */     double d = 0.0D;
/*  87 */     if ((price == null) || (price.trim().equals("")) || (price.equals("null"))) {
/*  88 */       d = 0.0D;
     } else {
       try
       {
/*  92 */         d = Double.parseDouble(price);
       } catch (NumberFormatException ex) {
/*  94 */         d = 0.0D;
       } catch (Exception ex) {
/*  96 */         d = 0.0D;
       }
     }
/*  99 */     return formatValue(d);
   }
   
 
 
 
 
   public static Long procLong(String value)
   {
/* 108 */     if ((value == null) || (value.trim().equals("")) || (value.trim().equals("null"))) {
/* 109 */       return new Long("0");
     }
/* 111 */     return new Long(value.trim());
   }
   
 
 
 
 
   public static int procInt(String value)
   {
     try
     {
/* 122 */       if ((value == null) || (value.trim().equals("")) || (value.trim().equals("null"))) {
/* 123 */         return 0;
       }
/* 125 */       return Integer.parseInt(value.trim());
     }
     catch (Exception e) {}
/* 128 */     return 0;
   }
   
 
 
 
 
 
   public static String procStrToInt(String value)
   {
/* 138 */     if ((value == null) || (value.trim().equals("")) || (value.trim().equals("null"))) {
/* 139 */       return "0";
     }
/* 141 */     int iNum = value.indexOf(".");
/* 142 */     if (iNum == -1) {
/* 143 */       return value;
     }
/* 145 */     return value.substring(0, iNum);
   }
   
 
 
 
 
 
 
   public static BigDecimal procBigDecimal(Object value)
   {
/* 156 */     if ((value == null) || (value.toString().trim().equals(""))) {
/* 157 */       return new BigDecimal("0");
     }
/* 159 */     return new BigDecimal(value.toString());
   }
   
 
 
 
 
 
   public static String tranData(Object value)
   {
/* 169 */     if ((value == null) || (value.toString().trim().equals(""))) {
/* 170 */       return "0.0000";
     }
/* 172 */     String strRet = formatValue4(procDouble(procString(value)).doubleValue());
     
/* 174 */     return strRet;
   }
   
 
 
 
 
 
   public static Double procDouble(String value)
   {
/* 184 */     if ((value == null) || (value.trim().equals("")) || (value.trim().equals("null"))) {
/* 185 */       return new Double("0");
     }
/* 187 */     return new Double(value);
   }
   
 
 
 
 
 
   public static String procString(Object value)
   {
/* 197 */     if ((value == null) || (value.toString().trim().equals(""))) {
/* 198 */       return "";
     }
/* 200 */     return String.valueOf(value);
   }
   
 
 
 
 
 
   public static final List<String> parseStringToArrayList(String strlist, String ken)
   {
/* 210 */     StringTokenizer st = new StringTokenizer(strlist, ken);
     
/* 212 */     if ((strlist == null) || (strlist.equals("")) || (st.countTokens() <= 0)) {
/* 213 */       return new ArrayList();
     }
     
/* 216 */     int size = st.countTokens();
/* 217 */     List<String> strv = new ArrayList();
     
/* 219 */     for (int i = 0; i < size; i++) {
/* 220 */       String nextstr = st.nextToken();
/* 221 */       if (!nextstr.equals("")) {
/* 222 */         strv.add(nextstr);
       }
     }
/* 225 */     return strv;
   }
   
 
 
 
 
 
   public static boolean isEmpty(String s)
   {
/* 235 */     return (s == null) || (s.trim().length() == 0) || (s.trim().equals("null"));
   }
   
 
 
 
 
 
   public static String isEmptyDo(String s)
   {
/* 245 */     return isEmpty(s) ? "" : s;
   }
   
 
 
 
 
   public static String join(String[] s, String tok)
   {
/* 254 */     if ((s == null) || (s.length == 0)) {
/* 255 */       return "";
     }
/* 257 */     if ((tok == null) || (tok.length() == 0)) {
/* 258 */       tok = ",";
     }
     
/* 261 */     StringBuffer rval = new StringBuffer();
     
/* 263 */     for (int i = 0; i < s.length; i++) {
/* 264 */       rval.append(s[i]);
       
/* 266 */       if (s.length - 1 != i) {
/* 267 */         rval.append(tok);
       }
     }
     
/* 271 */     return rval.toString();
   }
   
 
 
 
 
 
   public static String getStr(String text, int iv)
   {
/* 281 */     if (text == null) {
/* 282 */       return "";
     }
/* 284 */     StringBuffer strBuff = new StringBuffer();
     
/* 286 */     if (text.length() > iv) {
/* 287 */       strBuff.append(text.substring(0, iv));
/* 288 */       strBuff.append("...");
/* 289 */       return strBuff.toString();
     }
/* 291 */     return text;
   }
   
 
 
 
 
 
 
   public static String getStrLen(String text, int iv)
   {
/* 302 */     if (text == null) {
/* 303 */       return "";
     }
     
 
 
 
/* 309 */     return text;
   }
   
   public static String getStr1(String text, int iv, int sign, String jzxxlh)
   {
/* 314 */     if (text == null) {
/* 315 */       return "";
     }
/* 317 */     StringBuffer strBuff = new StringBuffer();
     
/* 319 */     if (text.length() > iv) {
/* 320 */       strBuff.append(text.substring(0, iv));
/* 321 */       strBuff.append("......&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' onClick=\"showimgdetail('");
/* 322 */       strBuff.append(sign);
/* 323 */       strBuff.append("', '");
/* 324 */       strBuff.append(jzxxlh);
/* 325 */       strBuff.append("');return false;\"><font color='#0000CC'>More</font></a>");
/* 326 */       return strBuff.toString();
     }
/* 328 */     return text;
   }
   
 
 
 
 
 
 
   public static String setStr(String str)
   {
/* 339 */     if ((str == null) || (str.equals(""))) {
/* 340 */       return "";
     }
     
/* 343 */     str = str.trim();
/* 344 */     if (str.equals("无")) {
/* 345 */       return "";
     }
     
/* 348 */     if (str.equals("/")) {
/* 349 */       return "";
     }
     
/* 352 */     return str;
   }
   
 
 
 
 
   public static String procStr(String text)
   {
/* 361 */     if (text == null) {
/* 362 */       return "";
     }
/* 364 */     if (text.indexOf("'") != -1) {
/* 365 */       text = text.replace("'", "''");
     }
/* 367 */     return text;
   }
   
 
 
 
 
   public static String setSize(long isize)
   {
/* 376 */     BigDecimal bsize = new BigDecimal(isize).divide(new BigDecimal(1024), 2, 4);
     
/* 378 */     if (bsize.compareTo(new BigDecimal(1000)) < 0) {
/* 379 */       return bsize + "KB";
     }
/* 381 */     return bsize.divide(new BigDecimal(1024), 2, 4) + "M";
   }
 }
