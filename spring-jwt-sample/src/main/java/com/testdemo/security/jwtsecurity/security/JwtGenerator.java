package com.testdemo.security.jwtsecurity.security;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.testdemo.security.jwtsecurity.model.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGenerator {


    public String generate(JwtUser jwtUser) {


        Claims claims = Jwts.claims()
                .setSubject(jwtUser.getUserName());
        claims.put("userId", String.valueOf(jwtUser.getId()));
        claims.put("role", jwtUser.getRole());
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
    	String dateInString = "19-03-2018 11:00:00";
    	Date expiryDate = null;
		try {
			expiryDate = sdf.parse(dateInString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Error parsing Date ");
			e.printStackTrace();
			
		}

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date()).setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, "tempKey")
                .compact();
    }
}
