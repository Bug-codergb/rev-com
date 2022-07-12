package com.codergb.dto.book;

import com.codergb.bean.book.BookCateCh;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class BookCateChDTO extends BookCateCh {
  private String cateId;
}
