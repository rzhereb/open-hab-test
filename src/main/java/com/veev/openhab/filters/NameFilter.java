package com.veev.openhab.filters;

import java.util.List;

public interface NameFilter<T> {

    List<T> filterByName(List<T> list, String value);
}
