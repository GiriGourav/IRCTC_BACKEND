package com.irctc.backend.Service;

import com.irctc.backend.dto.PageResponse;
import com.irctc.backend.dto.TrainDto;
import com.irctc.backend.entity.Train;
import com.irctc.backend.exceptions.ResourceNotFoundException;
import com.irctc.backend.repositories.TrainRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;

@Service
public class TrainService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private TrainRepository trainRepository;

    public TrainService(ModelMapper modelMapper, TrainRepository trainRepository) {
        this.modelMapper = modelMapper;
        this.trainRepository = trainRepository;
    }

    //    add train
    public TrainDto add(TrainDto trainDto)
    {
//        convert dto to entity
//        Train train = new Train();
//        train.setTrainNumber(trainDto.getTrainNumber());
//        train.setTrainName(trainDto.getTrainName());
//        train.setRouteName(trainDto.getRouteName());
        Train train = modelMapper.map(trainDto, Train.class);
       Train savedTrain= trainRepository.save(train);
//       convert entity into dto
//        TrainDto dto=new TrainDto();
//        dto.setTrainNumber(savedTrain.getTrainNumber());
//        dto.setTrainName(savedTrain.getTrainName());
//        dto.setRouteName(savedTrain.getRouteName());
        TrainDto dto=modelMapper.map(savedTrain, TrainDto.class);
        return dto;
    }
//    get all trains
    public PageResponse<TrainDto> all(int page, int size, String sortBy, String sortDir)
    {
//     kuch aisa likhna hai ke paggination implement ho jaye
        Sort sort = sortBy.trim().toLowerCase().equals("asc")? Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page  <Train> trainPage = trainRepository.findAll(pageable);
         Page<TrainDto> trainDtoPage= trainPage.map(train -> modelMapper.map(train, TrainDto.class));
         return PageResponse.fromPage(trainDtoPage);
    }
//    get train by id
    public TrainDto getTrainById(String trainNumber)
    {
          Train train=  trainRepository.findById(trainNumber).orElseThrow(() -> new ResourceNotFoundException("Train not found")) ;
          return modelMapper.map(train,TrainDto.class);
    }
//    delete train
    public Void deleteTrain(String trainNumber)
    {
        trainRepository.findById(trainNumber).orElseThrow(() -> new ResourceNotFoundException("Train not found"));
        trainRepository.deleteById(trainNumber);
        return null;
    }
}
