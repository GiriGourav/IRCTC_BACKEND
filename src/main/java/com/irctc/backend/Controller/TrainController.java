package com.irctc.backend.Controller;

import com.irctc.backend.Service.FileUploadService;
import com.irctc.backend.Service.TrainService;
import com.irctc.backend.dto.ErrorResponse;
import com.irctc.backend.dto.ImageMetaData;
import com.irctc.backend.entity.Train;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/trains")
public class TrainController {
    @Autowired
    private TrainService trainService;

    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping("/photo")
    public ImageMetaData uploadtrainupload(
            @RequestParam("file") MultipartFile file) throws IOException {
//        using Repository save this to database
        return fileUploadService.uploadImage(file);
    }

    @GetMapping()
    public List<Train> getAll()
    {
        return this.trainService.getAll();
    }
    @GetMapping("/{trainNumber}")
    public Train getTrainById(@PathVariable String trainNumber)
    {
        return this.trainService.getTrainById(trainNumber);
    }
    @DeleteMapping("/{trainNumber}")
    public void deleteTrain(@PathVariable String trainNumber)
    {
        this.trainService.deleteTrain(trainNumber);
    }
    @PostMapping()
    public ResponseEntity<Train> add(@Valid @RequestBody Train train)
    {

        return new ResponseEntity<>(this.trainService.add(train), HttpStatus.CREATED);
    }
//    @RequestMapping("/train")
//    public List<Train> getTrain() {
//
//        List<Train> trains = new ArrayList<>();
//        Train train = new Train();
//        train.setTrainName("LKO-Delhi Super Fast");
//        train.setCoaches(10);
//        trains.add(train);
//
//        Train train2 = new Train();
//        train2.setTrainName("LKO-Mumbai Super Fast");
//        train2.setTrainNumber("1235");
//        train2.setCoaches(15);
//        trains.add(train2);
//        return trains;    }
//    @ExceptionHandler(NoSuchElementException.class)
//    public ErrorResponse handelNoSuchElementException(NoSuchElementException exception)
//    {
//       ErrorResponse response= new ErrorResponse("Train not found !!" + exception.getMessage(), "404", false);
//       return response;
//    }
}
