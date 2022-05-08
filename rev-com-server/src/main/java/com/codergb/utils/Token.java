package com.codergb.utils;
import com.codergb.bean.User;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


public class Token {
  private static final long Expire=60000*60*24*7;
  private static final String privateKey=new ReadFileToString(System.getProperty("user.dir")+"/src/main/java/com/codergb/key/public.key").readFile();
  public String createJWT(User user){
    String token=Jwts.builder().setSubject(user.getUserId())
                               .claim("userId",user.getUserId())
                               .claim("userName",user.getUserName())
                               .setIssuedAt(new Date())
                               .setExpiration(new Date(System.currentTimeMillis()+Expire))
                               .signWith(SignatureAlgorithm.HS256,privateKey).compact();

    return token;
  }
  public Claims parseToken(String token){
    Claims claims=Jwts.parser().setSigningKey(privateKey).parseClaimsJws(token).getBody();
    return claims;
  }
}
