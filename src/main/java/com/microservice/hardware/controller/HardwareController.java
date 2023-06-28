package com.microservice.hardware.controller;

import com.microservice.hardware.model.Hardware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.microservice.hardware.service.HardwareService;
import com.microservice.hardware.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.annotation.*;
@RestController
@RequestMapping(value = "hardware-service", produces = MediaType.APPLICATION_JSON_VALUE)
public class HardwareController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    HardwareService hardwareService;

    private String service = "Hardware";

    @PostMapping /*Komunikasi API dengan jenis POST*/
    ResponseEntity<Response> create (@RequestBody @Validated Hardware hardware) /*Mengambil Request data dari Body dan melakukan Proses Validasi*/
    {
        /*Informasi Tentang Nama Method*/
    	log.info("berhasil masuk controller");
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameofCurrMethod);
        response.setMessage("Berhasil Membuat Data");

        /*Set Data Dari Database*/
        response.setData(hardwareService.create(hardware));

        return  ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @PutMapping(value = "{id}")/*Komunikasi API dengan jenis PUT*/
    ResponseEntity<Response> update (@PathVariable ("id")Long id, @RequestBody @Validated Hardware hardware) /*Mengambil Request data dari Body dan melakukan Proses Validasi, diseleksi berdasarkan id*/
    {
    	log.info(String.valueOf(id == (long)id));
    	/*Informasi Tentang Nama Method*/
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        Response response = new Response();
        response.setService(this.getClass().getName() + nameofCurrMethod);
        response.setMessage("Berhasil Update Data");

        /*Set Data Dari Database*/
        response.setData(hardwareService.update(id, hardware));
        System.out.println(4);

        return  ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping(value = "{id}")/*Komunikasi API dengan jenis GET*/
    Hardware getById (@PathVariable("id") Long id)/*Mengambil Request data dari Berdasarkan id*/
    {
        log.warn(String.valueOf(id));
        System.out.println("p");
    	/*Informasi Tentang Nama Method*/
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameofCurrMethod);
        response.setMessage("Berhasil Mengambil Data Berdasarkan Id");

        /*Set Data Dari Database*/
        //Long idl = Long.parseLong(id);
        System.out.println(7);
        response.setData(hardwareService.findById(id));
        
        System.out.println(hardwareService.findAll());
        System.out.println(10);

        // return  ResponseEntity
        //        .status(HttpStatus.OK)
        //        .contentType(MediaType.APPLICATION_JSON)
        //        .body(response);
        return hardwareService.findById(id);
    }

    @GetMapping/*Komunikasi API dengan jenis GET*/
    ResponseEntity<Response> findAll ()
    {
        /*Informasi Tentang Nama Method*/
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameofCurrMethod);
        response.setMessage("Berhasil Menampilkan Seluruh Data");

        /*Set Data Dari Database*/
        response.setData(hardwareService.findAll());

        return  ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
    
    @DeleteMapping(value = "{id}")/*Komunikasi API dengan jenis GET*/
    ResponseEntity<Response> deleteById (@PathVariable ("id")Long id)/*Mengambil Request data dari Berdasarkan id*/
    {
        /*Informasi Tentang Nama Method*/
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
        response.setService(this.getClass().getName() + nameofCurrMethod);
        response.setMessage("Data Berhasil dihapus");
        response.setData(hardwareService.findById(id));

        hardwareService.delete(id);

        return  ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }


}