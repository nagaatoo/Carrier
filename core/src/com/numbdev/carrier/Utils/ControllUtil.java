package com.numbdev.carrier.Utils;

import com.numbdev.carrier.Controller.Controller;
import com.numbdev.carrier.Enum.ControllerType;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Утилитный класс для работы с контроллерами.
 */
public final class ControllUtil {

    /**
     * Возвращает котроллеры заданного типа.
     * @param type тип контроллера
     * @param contrillers контроллеры
     * @return найденные контроллеры
     */
    public static List<Controller> getControllerByType(ControllerType type, List<Controller> contrillers) {
        return  contrillers.stream().filter(item -> item.typeControll().equals(type)).collect(Collectors.toList());
    }
}
