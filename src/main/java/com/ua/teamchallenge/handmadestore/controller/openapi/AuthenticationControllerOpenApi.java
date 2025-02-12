package com.ua.teamchallenge.handmadestore.controller.openapi;

import com.ua.teamchallenge.handmadestore.dto.AuthenticationRequest;
import com.ua.teamchallenge.handmadestore.dto.AuthenticationResponse;
import com.ua.teamchallenge.handmadestore.dto.RefreshTokenRequest;
import com.ua.teamchallenge.handmadestore.dto.RefreshTokenResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Authentication Controller", description = "API to work with authentication")
public interface AuthenticationControllerOpenApi {
    @Operation(summary = "User authentication")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "User successfully authenticated",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = AuthenticationResponse.class))),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad request. Missing required parameters"),
            @ApiResponse(
                    responseCode = "404",
                    description = "Wrong credentials"),
            @ApiResponse(
                    responseCode = "500",
                    description = "Unexpected internal error")
    })
    AuthenticationResponse login(@Valid @RequestBody AuthenticationRequest request);

    @Operation(summary = "Get new access token by refresh token")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "New access token successfully generated",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = RefreshTokenResponse.class))),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad request. Missing required parameters"),
            @ApiResponse(
                    responseCode = "403",
                    description = "Token has expired"),
            @ApiResponse(
                    responseCode = "404",
                    description = "Token not found"),
            @ApiResponse(
                    responseCode = "500",
                    description = "Unexpected internal error")
    })
    public RefreshTokenResponse refreshToken(@Valid @RequestBody RefreshTokenRequest request);
}
