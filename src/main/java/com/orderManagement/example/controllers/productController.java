package com.orderManagement.example.controllers;

import com.orderManagement.example.Service.productService;
import com.orderManagement.example.dto.productDTO;
import com.orderManagement.example.models.product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class productController {
    private final productService service ;

    public productController(productService service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    @Operation(
            description = "get all products ",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully get all products !",
                            content = @Content(
                                    mediaType ="application/json",
                                    examples = {
                                            @ExampleObject(
                                                    value = "{\"code\" : 200, \"Status\" : \"Ok!\", \"Message\" :\"Successfully get all products !\"}"
                                            ),
                                    }
                            )
                    )
            }
    )
    public List<product> getProducts() {
        return service.getAllProduct();
    }

    @GetMapping("/get")
    @Operation(
            description = "get product ",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully get product !",
                            content = @Content(
                                    mediaType ="application/json",
                                    examples = {
                                            @ExampleObject(
                                                    value = "{\"code\" : 200, \"Status\" : \"Ok!\", \"Message\" :\"Successfully get product !\"}"
                                            ),
                                    }
                            )
                    )
            }
    )
    public productDTO getProductById(@RequestParam(required = true) Integer id ) {
        return service.getProductById(id);
    }

    @DeleteMapping(path = "/delete")
    @Operation(
            description = "delete product ",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully delete product!",
                            content = @Content(
                                    mediaType ="application/json",
                                    examples = {
                                            @ExampleObject(
                                                    value = "{\"code\" : 200, \"Status\" : \"deleted!\", \"Message\" :\"Successfully delete product !\"}"
                                            ),
                                    }
                            )
                    )
            }
    )
    public Boolean deleteProduct(@RequestParam(required = true) Integer id) {
        return service.deleteProduct(id);
    }

    @PostMapping("/insert")
    @Operation(
            description = "create product ",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Successfully create product!",
                            content = @Content(
                                    mediaType ="application/json",
                                    examples = {
                                            @ExampleObject(
                                                    value = "{\"code\" : 201, \"Status\" : \"created!\", \"Message\" :\"Successfully create product !\"}"
                                            ),
                                    }
                            )
                    )
            }
    )
    public Boolean insertProduct(@RequestBody productDTO productDTO) {
        return service.createProduct(productDTO);
    }

    @PutMapping("/update")
    @Operation(
            description = "update product ",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully update product!",
                            content = @Content(
                                    mediaType ="application/json",
                                    examples = {
                                            @ExampleObject(
                                                    value = "{\"code\" : 200, \"Status\" : \"updated!\", \"Message\" :\"Successfully update product !\"}"
                                            ),
                                    }
                            )
                    )
            }
    )
    public boolean updateProduct(@RequestParam(required = true) Integer id,@RequestBody productDTO productDTO) {
        return service.updateProduct(id,productDTO);
    }
}
