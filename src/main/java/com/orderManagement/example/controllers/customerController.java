package com.orderManagement.example.controllers;

import com.orderManagement.example.Service.customerService;
import com.orderManagement.example.dto.customerDTO;
import com.orderManagement.example.dto.orderDTO;
import com.orderManagement.example.models.customer;
import com.orderManagement.example.models.order;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/customer")
@CrossOrigin
public class customerController {
    private final customerService service ;

    public customerController(customerService service) {
        this.service = service;
    }


    @GetMapping("/getAll")
    @Operation(
            description = "get all customers ",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully get all customers !",
                            content = @Content(
                                    mediaType ="application/json",
                                    examples = {
                                            @ExampleObject(
                                                    value = "{\"code\" : 200, \"Status\" : \"Ok!\", \"Message\" :\"Successfully get all customers !\"}"
                                            ),
                                    }
                            )
                    )
            }
    )
    public List<customer> getCustomer() {
        return service.getAllCustomer();
    }

    @GetMapping("/get")
    @Operation(
            description = "get customer ",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully get customer !",
                            content = @Content(
                                    mediaType ="application/json",
                                    examples = {
                                            @ExampleObject(
                                                    value = "{\"code\" : 200, \"Status\" : \"Ok!\", \"Message\" :\"Successfully get customer !\"}"
                                            ),
                                    }
                            )
                    )
            }
    )
    public customerDTO getCustomerById(@RequestParam(required = true) Integer id ) {
        return service.getCustomerById(id);
    }

    @DeleteMapping(path = "/delete")
    @Operation(
            description = "delete customer ",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully delete customer !",
                            content = @Content(
                                    mediaType ="application/json",
                                    examples = {
                                            @ExampleObject(
                                                    value = "{\"code\" : 200, \"Status\" : \"deleted!\", \"Message\" :\"Successfully delete customer !\"}"
                                            ),
                                    }
                            )
                    )
            }
    )
    public Boolean deleteCustomer(@RequestParam(required = true) Integer id) {
        return service.deleteCustomer(id);
    }

    @PostMapping("/insert")
    @Operation(
            description = "create customer ",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Successfully create customer !",
                            content = @Content(
                                    mediaType ="application/json",
                                    examples = {
                                            @ExampleObject(
                                                    value = "{\"code\" : 201, \"Status\" : \"created!\", \"Message\" :\"Successfully create customer !\"}"
                                            ),
                                    }
                            )
                    )
            }
    )
    public Boolean insertCustomer(@RequestBody customerDTO customerDTO) {
        return service.createCustomer(customerDTO);
    }

    @PutMapping("/update")
    @Operation(
            description = "update customer ",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully update customer !",
                            content = @Content(
                                    mediaType ="application/json",
                                    examples = {
                                            @ExampleObject(
                                                    value = "{\"code\" : 200, \"Status\" : \"updated!\", \"Message\" :\"Successfully update customer !\"}"
                                            ),
                                    }
                            )
                    )
            }
    )
    public boolean updateCustomer(@RequestParam(required = true) Integer id,@RequestBody customerDTO customerDTO) {
        return service.updateCustomer(id,customerDTO);
    }
}
