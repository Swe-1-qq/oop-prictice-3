package com.swe1qq.opp.practice3.domain;

import com.swe1qq.opp.practice3.persistence.entity.Case;
import com.swe1qq.opp.practice3.persistence.entity.Motherboard;
import java.util.List;

public interface Assembly {

    void addComponent(Component component);

    double calculateTotalPrice();

    String getDescription();

    List<Component> getComponents();

    void connectToMotherboard(Motherboard motherboard);

    void connectToCase(Case computerCase);
}
