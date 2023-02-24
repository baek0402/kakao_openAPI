package openAPI.TmiBoard.security;

import lombok.RequiredArgsConstructor;
import openAPI.TmiBoard.repository.kakao.KakaoUserRepository;
import openAPI.TmiBoard.service.kakao.oauth.KakaoOauthService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter {

    private final AuthenticationFailureHandler authenticationFailureHandler;
    private final AuthenticationSuccessHandler authenticationSuccessHandler;
    private final AccessDeniedHandler accessDeniedHandler;

    private final KakaoOauthService kakaoOauthService;
    private final KakaoUserRepository kakaoUserRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Kakao 로그인 인증 필터
        /*CustomKakaoAuthenticationFilter customKakaoAuthenticationFilter =
                new CustomKakaoAuthenticationFilter(kakaoOauthService, kakaoUserRepository, authenticationManagerBean());//
        customKakaoAuthenticationFilter.setFilterProcessesUrl("/api/oauth/kakao");
        customKakaoAuthenticationFilter.setAuthenticationFailureHandler(authenticationFailureHandler);
        customKakaoAuthenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
        */

        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // 세션 사용 X
        //http.authorizeRequests().antMatchers("/api/my/**").hasAnyAuthority("ROLE_USER");
        //http.authorizeRequests().antMatchers("/api/admin/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().anyRequest().permitAll();
        //http.addFilter(customKakaoAuthenticationFilter);
        //http.addFilterBefore(customAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
        //http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);

        http.oauth2Login();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
