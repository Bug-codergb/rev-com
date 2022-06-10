package com.codergb.dto.music.artist;

import com.codergb.bean.music.artist.Artist;
import lombok.*;
import org.springframework.boot.convert.DataSizeUnit;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class ArtistDTO extends Artist {
  private String cateId;
  private String typeId;
}
