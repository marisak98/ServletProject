package com.touhousoft.taskproject.utils;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.JsonReader;

import java.time.format.DateTimeFormatter;
import java.io.IOException;
import java.time.LocalDate;

/**
 * LocalDataAdapter
 */
public class LocalDataAdapter extends TypeAdapter<LocalDate> {

  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  @Override
  public void write(JsonWriter jsonWriter, LocalDate localDate) throws IOException {
    jsonWriter.value(localDate != null ? localDate.format(formatter) : null);
  }

  @Override
  public LocalDate read(JsonReader jsonReader) throws IOException {
    String date = jsonReader.nextString();
    return date != null ? LocalDate.parse(date, formatter) : null;
  }
}
