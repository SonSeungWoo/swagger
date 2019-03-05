package me.seungwoo;

import io.swagger.annotations.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Leo.
 * User: ssw
 * Date: 2019-03-05
 * Time: 13:21
 */
@RestController
@RequiredArgsConstructor
public class MainController {

    private final UserRepository userRepository;

    @ApiOperation(value = "user", nickname = "user")
    @GetMapping("/user/{username}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "User's name", required = false, dataType = "string", paramType = "query")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = User.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public User getUser(@PathVariable("username") String username){
        return userRepository.findbyUsername(username);
    }
}
