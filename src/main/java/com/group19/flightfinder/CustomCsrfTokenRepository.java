package com.group19.flightfinder;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.web.util.WebUtils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.UUID;

public class CustomCsrfTokenRepository implements CsrfTokenRepository {

    private static final String CSRF_TOKEN_ATTR_NAME = "_csrf";
    private static final String CSRF_HEADER_NAME = "X-CSRF-TOKEN";

    @Override
    public CsrfToken generateToken(HttpServletRequest request) {
        return new CsrfToken() {
            private final String token = UUID.randomUUID().toString();

            @Override
            public String getHeaderName() {
                return CSRF_HEADER_NAME;
            }

            @Override
            public String getParameterName() {
                return CSRF_TOKEN_ATTR_NAME;
            }

            @Override
            public String getToken() {
                return this.token;
            }
        };
    }

    @Override
    public void saveToken(CsrfToken token, HttpServletRequest request, HttpServletResponse response) {
        if (token == null) {
            WebUtils.setSessionAttribute(request, CSRF_TOKEN_ATTR_NAME, null);
        } else {
            WebUtils.setSessionAttribute(request, CSRF_TOKEN_ATTR_NAME, token);
        }
    }

    @Override
    public CsrfToken loadToken(HttpServletRequest request) {
        return (CsrfToken) WebUtils.getSessionAttribute(request, CSRF_TOKEN_ATTR_NAME);
    }
}
