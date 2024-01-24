package qbittorrent.api.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * This class is used to prevent numbers in the API defined as a long from
 * returning java.lang.NumberFormatException when the value is larger than
 * a long.
 */
public class LongTypeAdapter extends TypeAdapter<Long> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LongTypeAdapter.class);

    @Override
    public Long read(JsonReader reader) throws IOException {
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
            return 0L;
        }
        String value = reader.nextString();
        try {
            return Long.valueOf(value);
        } catch (NumberFormatException e) {
            LOGGER.debug("Could not read long {} which had an invalid long value. Defaulting value to 0.", value);
            return 0L;
        }
    }

    @Override
    public void write(JsonWriter writer, Long value) throws IOException {
        if (value == null) {
            writer.nullValue();
            return;
        }
        writer.value(value);
    }
}
