package com.codergb.bean.wangEditor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WangEditor {
  private Integer errno;
  private String message;
  private WangData data;
}
