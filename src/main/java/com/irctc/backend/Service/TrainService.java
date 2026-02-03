package com.irctc.backend.Service;

import com.irctc.backend.entity.Train;
import com.irctc.backend.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TrainService {

    List<Train> trainList = new ArrayList<>();
    public TrainService() {
        trainList.add(new Train("1234","LKO-Delhi Super Fast",10));
        trainList.add(new Train("1235","LKO-Mumbai Super Fast",15));
    }
//    add train
    public Train add(Train train)
    {
        trainList.add(train);
        return train;
    }
//    get all trains
    public List<Train> getAll()
    {
        return trainList;
    }
//    get train by id
    public Train getTrainById(String trainNumber)
    {
        Train train1= trainList.stream().filter(train -> train.getTrainNumber().equals(trainNumber))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Train not found in database!!"));
        return train1;
    }
//    delete train
    public Void deleteTrain(String trainNumber)
    {
        List<Train> list=trainList.stream().filter(train -> !train.getTrainNumber().equals(trainNumber)).toList();
        this.trainList=list;
        return null;
    }
}
