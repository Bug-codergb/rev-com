package com.codergb.utils;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class Spell {
  public String changeSpell(String chinese){
    char[] chineseArr=chinese.trim().toCharArray();
    StringBuilder spell=new StringBuilder();
    HanyuPinyinOutputFormat format=new HanyuPinyinOutputFormat();
    format.setCaseType(HanyuPinyinCaseType.LOWERCASE);//输出小写
    format.setToneType(HanyuPinyinToneType.WITHOUT_TONE); //没有音标
    format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);
    try{
      for(int i=0;i<chineseArr.length;i++){
        if(Character.toString(chineseArr[i]).matches("[\\u4E00-\\u9FA5]+")){
          String[] pys= PinyinHelper.toHanyuPinyinStringArray(chineseArr[i],format);
          spell.append(pys[0]);
        }
      }
    }catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination){
      badHanyuPinyinOutputFormatCombination.printStackTrace();
    }
    return spell.toString();
  }
}
