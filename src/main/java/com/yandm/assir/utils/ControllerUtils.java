package com.yandm.assir.utils;

import static java.util.Arrays.asList;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.google.common.base.Function;
import com.google.common.collect.Lists;

public class ControllerUtils {

   public static String getActionFromPath(String pathInfo) {
      return pathInfo.substring(1);
   }

   public static List<Long> idsToLong(HttpServletRequest req, String parameterName) {
      return Lists.transform(
            asList(req.getParameterValues(parameterName)),
            new Function<String, Long>() {
               @Override
               public Long apply(String input) {
                  return Long.valueOf(input);
               }
            });
   }
   }