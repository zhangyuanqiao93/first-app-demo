package firstappdemo.config;

import firstappdemo.entity.UserEntity;
import firstappdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import java.util.Collection;
/**
 * 路由器 配置
 *
 */

@Configuration
public class RouterFunctionConfiguration {

    /**
     * Servlet
     *     请求接口：ServletRequest or  HttpServletRequest
     *     响应接口：ServletResponse or  HttpServletResponse
     *
     *  Spring 5.0重新定义了接口
     *  ServletRequest and ServletResponse
     *
     * 支持Servlet规范，同时也支持Netty（Web Servlet）
     *  定义GET请求，返回所有用户，URL：/person/find/all
     *
     *  Flux:0-N个对象集合
     *  Mono：0-1个兑现集合
     *  Reactive 中的Flux或者Mono是异步处理（非阻塞）
     *  集合基本是同步处理（阻塞）
     *  Flux or Mono 都是Publisher
     */
    @Bean
    @Autowired//通过方法注入
    public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository){

        return RouterFunctions.route(RequestPredicates.GET("/person/find/all"),
                request->{
                    //返回所有对象
                    Collection<UserEntity> users = userRepository.findAll();
                    Mono<ServerResponse> response = null;
                    Flux<UserEntity> userEntityFlux = Flux.fromIterable(users);
                    return ServerResponse.ok().body(userEntityFlux,UserEntity.class);
            });
    }

}
