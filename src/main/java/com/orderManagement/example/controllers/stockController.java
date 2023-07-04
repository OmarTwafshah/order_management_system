package com.orderManagement.example.controllers;

import com.orderManagement.example.Service.stockService;
import com.orderManagement.example.dto.stockDTO;
import com.orderManagement.example.models.stock;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
@CrossOrigin
public class stockController {
    private final stockService service ;

    public stockController(stockService service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    @Operation(
            description = "get all stocks ",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully get all stocks !",
                            content = @Content(
                                    mediaType ="application/json",
                                    examples = {
                                            @ExampleObject(
                                                    value = "{\"code\" : 200, \"Status\" : \"Ok!\", \"Message\" :\"Successfully get all stocks !\"}"
                                            ),
                                    }
                            )
                    )
            }
    )
    public List<stock> getStock() {
        return service.getAllStock();
    }

    @GetMapping("/get")
    @Operation(
            description = "get stock",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully get stock !",
                            content = @Content(
                                    mediaType ="application/json",
                                    examples = {
                                            @ExampleObject(
                                                    value = "{\"code\" : 200, \"Status\" : \"Ok!\", \"Message\" :\"Successfully get stock !\"}"
                                            ),
                                    }
                            )
                    )
            }
    )
    public stockDTO getStockById(@RequestParam(required = true) Integer id ) {
        return service.getStockById(id);
    }

    @DeleteMapping(path = "/delete")
    @Operation(
            description = "delete stock",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully delete stock !",
                            content = @Content(
                                    mediaType ="application/json",
                                    examples = {
                                            @ExampleObject(
                                                    value = "{\"code\" : 200, \"Status\" : \"deleted!\", \"Message\" :\"Successfully delete stock !\"}"
                                            ),
                                    }
                            )
                    )
            }
    )
    public Boolean deleteStock(@RequestParam(required = true) Integer id) {
        return service.deleteStock(id);
    }

    @PostMapping("/insert")
    @Operation(
            description = "create stock",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Successfully create stock !",
                            content = @Content(
                                    mediaType ="application/json",
                                    examples = {
                                            @ExampleObject(
                                                    value = "{\"code\" : 201, \"Status\" : \"created!\", \"Message\" :\"Successfully create stock !\"}"
                                            ),
                                    }
                            )
                    )
            }
    )
    public Boolean insertStock(@RequestBody stockDTO stockDTO) {
        return service.createStock(stockDTO);
    }

    @PutMapping("/update")
    @Operation(
            description = "update stock",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Successfully update stock !",
                            content = @Content(
                                    mediaType ="application/json",
                                    examples = {
                                            @ExampleObject(
                                                    value = "{\"code\" : 201, \"Status\" : \"updated!\", \"Message\" :\"Successfully update stock !\"}"
                                            ),
                                    }
                            )
                    )
            }
    )
    public boolean updateStock(@RequestParam(required = true) Integer id,@RequestBody stockDTO stockDTO) {
        return service.updateStock(id,stockDTO);
    }
}
