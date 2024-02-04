package com.ahmedhassan.MoviesMicroservice.Config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;


@Component
public class AuthFilter extends OncePerRequestFilter {
    private final String AUTH_URL = "http://localhost:8080/api/auth/validate";

    private final AuthValidateClient authValidateClient;

    public AuthFilter(AuthValidateClient authValidateClient) {
        this.authValidateClient = authValidateClient;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
         String authHeader = request.getHeader("authorization");
         String jwtToken;

        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            response.setStatus(403);
            return;
        }

        jwtToken = authHeader.substring(7);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setBearerAuth(jwtToken);
//        HttpEntity<Void> entity = new HttpEntity<>(headers);

try{
            ResponseEntity<Void> authResponse = authValidateClient.auth(jwtToken,  request.getRequestURI());
            if(authResponse.getStatusCode().is2xxSuccessful()) {
//                ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper((HttpServletResponse) response);
//                ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
//
//
                filterChain.doFilter(request, response);
//
//                String requestStr = mapRequestOrResponse(requestWrapper.getContentAsByteArray(),requestWrapper.getCharacterEncoding());
//
//                String responseStr = mapRequestOrResponse(responseWrapper.getContentAsByteArray(),responseWrapper.getCharacterEncoding());
//
//                responseWrapper.copyBodyToResponse();
            }
            else {
                response.setStatus(401);
                return;
            }
}
         catch (HttpClientErrorException e) {
            response.setStatus(403);
            return;
        }
    }

//return    public String mapRequestOrResponse(byte[] byteArray,String characterEncoding) throws UnsupportedEncodingException
//    {
//        String requestStr=null;
//        if(byteArray.length > 0) {
//            requestStr = new String(byteArray,characterEncoding );
//        }
//        return requestStr;
//
//    }
}
