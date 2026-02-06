package com.irctc.backend.Controller;

import com.irctc.backend.Service.TrainImageService;
import com.irctc.backend.Service.TrainService;
import com.irctc.backend.dto.ImageMetaData;
import com.irctc.backend.dto.PageResponse;
import com.irctc.backend.dto.TrainDto;
import com.irctc.backend.dto.TrainImageResponse;
import com.irctc.backend.repositories.TrainRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("/trains")
public class TrainController {
    @Autowired
    private TrainService trainService;

    @Autowired
    private TrainRepository trainRepository;



    @Autowired
    private TrainImageService trainImageService;



    @GetMapping
    public PageResponse<TrainDto> getAll(
                           @RequestParam (value="page", defaultValue = "0") int page,
                           @RequestParam (value="size", defaultValue = "10") int size,
                           @RequestParam (value="sortBy", defaultValue = "trainNumber") String sortBy,
                           @RequestParam (value="sortDir", defaultValue = "asc") String sortDir)
    {

        return this.trainService.all(page,size,sortBy,sortDir);
    }

    @GetMapping("/{trainNumber}")
    public ResponseEntity<TrainDto> getTrainById(@PathVariable String trainNumber)
    {
        return new ResponseEntity<>( this.trainService.getTrainById(trainNumber), HttpStatus.OK);
    }

    @DeleteMapping("/{trainNumber}")
    public void deleteTrain(@PathVariable String trainNumber)
    {
        trainRepository.deleteById(trainNumber);
    }

    @PostMapping()
    public ResponseEntity<TrainDto> add(@Valid @RequestBody TrainDto trainDto)
    {
         return new ResponseEntity<>( this.trainService.add(trainDto), HttpStatus.CREATED);

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
    @PostMapping("/upload/{trainNo}")
    public TrainImageResponse uploadTrainImage(
            @RequestParam("image") MultipartFile image,
            @PathVariable String trainNo) throws IOException
    {
        return trainImageService.upload(image, trainNo);
    }
}
