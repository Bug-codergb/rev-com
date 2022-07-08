package com.codergb.dto.book;

import com.codergb.bean.book.Book;
import lombok.*;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BookDTO extends Book {
  private String writerId;
  private String publishId;
}
