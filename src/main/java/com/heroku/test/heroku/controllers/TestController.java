package com.heroku.test.heroku.controllers;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;

@RestController
public class TestController {

    @RequestMapping("/message")
    public String test(@RequestBody byte[] body, HttpServletRequest httpServletRequest, @RequestHeader HttpHeaders httpHeaders) throws IOException, DecoderException {

        System.out.println(httpServletRequest.getMethod() + " " + httpServletRequest.getRequestURI());
        System.out.println(httpServletRequest.getRemoteAddr());
        System.out.println(httpServletRequest.getHeader("X-FORWARDED-FOR"));
        System.out.println(Hex.encodeHexString(body));
      //  System.out.println(decompress(Hex.decodeHex("1f8b08000000000000001d904b6f82400084ff8ad9ab6e5c046497a407f0490d0645ad7a69f685a23ccc820834fdefc5de6626f32593f90165f390c006a5ac4b3000b1e834362c46908521a2d1081a1645900a93401ab11122dc1cf131e9ba15b0b50128f2a7e2d27b734f95d9298b85ed6c1ce73414918afd048793f94a95e8fcdae8d675320b97d2c7cbd9b036ee2ecadd863de579b55ff72b5114eee770b1e5c794bbbbed659cddb4f4f1d56f0e92dd4f9eee858b83d3decee6d4377c42b4d6c596bacf0351b769caea6041d0da6f5fd7a35f57c53e50bc3a1ddd3c5b5f3ced26f62aacb222d477aab9e08f6ebc90451967b48cf3ec7ffb38d218e3484069510b1aa689218e0c0c4d823833b8d074c13b2cc9394dde7fc9ec7bb9ed02968ba6b353da4be29ea22206bf7fa6698aea54010000")));
        System.out.println(httpHeaders);

        return "ok";
    }

    public static String decompress(final byte[] compressed) throws IOException {
        final StringBuilder outStr = new StringBuilder();
        if ((compressed == null) || (compressed.length == 0)) {
            return "";
        }
        if (isCompressed(compressed)) {
            final GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressed));
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gis, "UTF-8"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                outStr.append(line);
            }
        } else {
            outStr.append(compressed);
        }
        return outStr.toString();
    }

    public static boolean isCompressed(final byte[] compressed) {
        return (compressed[0] == (byte) (GZIPInputStream.GZIP_MAGIC)) && (compressed[1] == (byte) (GZIPInputStream.GZIP_MAGIC >> 8));
    }

}
