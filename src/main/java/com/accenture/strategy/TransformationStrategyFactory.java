package com.accenture.strategy;

import com.accenture.model.TransformationMode;
import org.springframework.stereotype.Component;

@Component
public class TransformationStrategyFactory {

    public TransformationStrategy get(TransformationMode mode) {
        switch (mode) {
            case FIRST_LINE:
            default:
                return new FirstLineStrategy();
        }
    }

}
