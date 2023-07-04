package com.orderManagement.example.controllers;

import com.orderManagement.example.Service.orderService;
import com.orderManagement.example.dto.insertProduct_order;
import com.orderManagement.example.dto.orderDTO;
import com.orderManagement.example.models.order;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class orderController {
    private final orderService service ;

    public orderController(orderService service) {
        this.service = service;
    }


    @GetMapping("/getAll")
    @Operation(
            description = "get all orders ",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully get all orders !",
                            content = @Content(
                                    mediaType ="application/json",
                                    examples = {
                                            @ExampleObject(
                                                    value = "{\"code\" : 200, \"Status\" : \"Ok!\", \"Message\" :\"Successfully get all orders !\"}"
                                            ),
                                    }
                            )
                    )
            }
    )
    public List<order> getOrder() {
        return service.getAllOrder();
    }

    @GetMapping("/get")
    @Operation(
            description = "get order ",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully get order !",
                            content = @Content(
                                    mediaType ="application/json",
                                    examples = {
                                            @ExampleObject(
                                                    value = "{\"code\" : 200, \"Status\" : \"Ok!\", \"Message\" :\"Successfully get order !\"}"
                                            ),
                                    }
                            )
                    )
            }
    )
    public orderDTO getOrderById(@RequestParam(required = true) Integer id ) {
        return service.getOrderById(id);
    }

    @DeleteMapping(path = "/delete")
    @Operation(
            description = "delete order ",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully delete order !",
                            content = @Content(
                                    mediaType ="application/json",
                                    examples = {
                                            @ExampleObject(
                                                    value = "{\"code\" : 200, \"Status\" : \"deleted!\", \"Message\" :\"Successfully delete order !\"}"
                                            ),
                                    }
                            )
                    )
            }
    )
    public Boolean deleteOrder(@RequestParam(required = true) Integer id) {
        return service.deleteOrder(id);
    }

    @PostMapping("/insert")
    @Operation(
            description = "create order ",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Successfully create order !",
                            content = @Content(
                                    mediaType ="application/json",
                                    examples = {
                                            @ExampleObject(
                                                    value = "{\"code\" : 201, \"Status\" : \"created!\", \"Message\" :\"Successfully create order !\"}"
                                            ),
                                    }
                            )
                    )
            }
    )
    public Boolean insertOrder(@RequestBody orderDTO orderDTO) {
        return service.createOrder(orderDTO);
    }

    @PutMapping("/update")
    @Operation(
            description = "update order ",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully update order !",
                            content = @Content(
                                    mediaType ="application/json",
                                    examples = {
                                            @ExampleObject(
                                                    value = "{\"code\" : 200, \"Status\" : \"updated!\", \"Message\" :\"Successfully update order !\"}"
                                            ),
                                    }
                            )
                    )
            }
    )
    public boolean updateOrder(@RequestParam(required = true) Integer id,@RequestBody orderDTO orderDTO) {
        return service.updateOrder(id,orderDTO);
    }
}
