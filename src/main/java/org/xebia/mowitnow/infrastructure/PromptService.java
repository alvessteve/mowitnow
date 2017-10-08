package org.xebia.mowitnow.infrastructure;

import org.xebia.mowitnow.domain.model.mow.Mow;
import org.xebia.mowitnow.domain.service.OutputService;

public class PromptService implements OutputService {
    @Override
    public void showPosition(Mow mow) {
        System.out.println(mow.getPosition().toString() + "\n");
    }
}
