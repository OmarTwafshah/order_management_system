package com.orderManagement.example.controllers;


import com.orderManagement.example.Service.product_orderService;
import com.orderManagement.example.dto.insertProduct_order;
import com.orderManagement.example.dto.product_orderDTO;
import com.orderManagement.example.dto.twoInteger;
import com.orderManagement.example.models.product_order;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product_order")
@CrossOrigin
public class product_orderController {
    private final product_orderService service ;

    public product_orderController(product_orderService service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    @Operation(
            description = "get all product_orders ",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully get all product_orders !",
                            content = @Content(
                                    mediaType ="application/json",
                                    examples = {
                                            @ExampleObject(
                                                    value = "{\"code\" : 200, \"Status\" : \"Ok!\", \"Message\" :\"Successfully get all product_orders !\"}"
                                            ),
                                    }
                            )
                    )
            }
    )
    public List<product_order> getproduct_orders() {
        return service.getAllProduct_order();
    }

    @GetMapping("/get")
    @Operation(
            description = "get product_order ",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully get product_order !",
                            content = @Content(
                                    mediaType ="application/json",
                                    examples = {
                                            @ExampleObject(
                                                    value = "{\"code\" : 200, \"Status\" : \"Ok!\", \"Message\" :\"Successfully get product_order !\"}"
                                            ),
                                    }
                            )
                    )
            }
    )
    public product_orderDTO getproduct_orderById(@RequestParam(required = true) twoInteger id ) {
        return service.getProduct_orderById(id.getId1(),id.getId2());
    }

    @DeleteMapping(path = "/delete")
    @Operation(
            description = "delete product_order ",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully delete product_order !",
                            content = @Content(
                                    mediaType ="application/json",
                                    examples = {
                                            @ExampleObject(
                                                    value = "{\"code\" : 200, \"Status\" : \"deleted!\", \"Message\" :\"Successfully delete product_order !\"}"
                                            ),
                                    }
                            )
                    )
            }
    )
    public Boolean deleteProduct_order(@RequestParam(required = true) twoInteger id) {
        return service.deleteProduct_order(id.getId1(),id.getId2());
    }

    @PostMapping("/insert")
    @Operation(
            description = "create product_order ",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Successfully create product_order !",
                            content = @Content(
                                    mediaType ="application/json",
                                    examples = {
                                            @ExampleObject(
                                                    value = "{\"code\" : 201, \"Status\" : \"created!\", \"Message\" :\"Successfully create product_order !\"}"
                                            ),
                                    }
                            )
                    )
            }
    )
    public Boolean insertProduct_order(@RequestBody product_orderDTO product_orderDTO) {
        return service.createProduct_order(product_orderDTO);
    }

    @PutMapping("/update")
    @Operation(
            description = "update product_order ",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully update product_order !",
                            content = @Content(
                                    mediaType ="application/json",
                                    examples = {
                                            @ExampleObject(
                                                    value = "{\"code\" : 200, \"Status\" : \"updated!\", \"Message\" :\"Successfully update product_order !\"}"
                                            ),
                                    }
                            )
                    )
            }
    )
    public boolean updateProduct_order(@RequestBody insertProduct_order product_orderDTO) {
        return service.updateProduct_order(product_orderDTO.getTwoInteger().getId1(),
                product_orderDTO.getTwoInteger().getId2(),
                product_orderDTO.getProduct_order());
    }
}
