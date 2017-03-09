package com.test.common.Utility;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by ANOURI on 08/03/2017.
 */
public class ListUtility {

    public static <T> List<List<T>> partitions( final List<T> list, final int nbPartition)
    {
        if (list == null) {
            throw new IllegalArgumentException("list is null");
        }
        if (nbPartition <= 0) {
            throw new IndexOutOfBoundsException("nbPartition " + nbPartition + " must b > 0");
        }

        final List<List<T>> result = new ArrayList<>();
        for( int i = 0; i < list.size(); i++ ) {
            final int start = i * nbPartition;
            final int end = Math.min(start + nbPartition, list.size());
            if(start < end) {
                result.add(new ArrayList<T>( list.subList( start, end)));
            }
        }
        return result;
    }

    public static <T> List<List<T>> partitionsJava8(List<T> list, int nbPartition) {
        if (list == null) {
            throw new IllegalArgumentException("list is null");
        }
        if (nbPartition <= 0) {
            throw new IndexOutOfBoundsException("nbPartition " + nbPartition + " must b > 0");
        }

        return list.stream().collect(Collectors.collectingAndThen(Collectors.toList(), new Function<List<T>, List<List<T>>>() {
            @Override
            public List<List<T>> apply(List<T> list) {
                final List<List<T>> result = new ArrayList<>();
                int counter = 0;
                List<T> elements = new ArrayList<>();
                for (final T t : list) {
                    if (counter == 0) {
                        result.add(elements);
                    } else {
                        if (counter == nbPartition) {
                            elements = new ArrayList<>();
                            result.add(elements);
                            counter = 0;
                        }
                    }
                    ++counter;
                    elements.add(t);
                }
                return result;
            }
        }));
    }

    public static <T> List<List<T>> partitionsGuava(List<T> list, int nbPartition) {
        return Lists.partition(list, nbPartition);
    }
}
