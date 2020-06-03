package br.com.example.deusemar;

import org.ehcache.xml.XmlConfiguration;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.xml.sax.InputSource;

import javax.xml.xpath.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class ParameterService {

    private ParameterRepository parameterRepository;

    private ResourceLoader resourceLoader;

    public  ParameterService(ParameterRepository parameterRepository, ResourceLoader resourceLoader){
        this.parameterRepository = parameterRepository;
        this.resourceLoader = resourceLoader;
    }

    @Cacheable(value = "parameters", sync = true)
    public Iterable<Parameter> findAllParameters(){
        System.out.println("Entrance method findAll from database");
        writeLogCacheTimeToLive();
        return this.parameterRepository.findAll();
    }

    public void save(Parameter parameter){
        this.parameterRepository.save(parameter);
    }

    /** Workaround to get print configuration file
     *
     */
    private void writeLogCacheTimeToLive() {

        System.out.println("Get Configuration Cache Expiry on ehcache.xml ");

        List<String> xmlLines = null;
        try {
            File file = ResourceUtils.getFile("classpath:ehcache.xml");
            InputStream inputStream = new FileInputStream(file);

            xmlLines = Files.readAllLines(Paths.get(file.getPath()), Charset.defaultCharset());
        } catch (IOException e) {
            System.out.println("Erro load classpath:ehcache.xml" + e.getMessage());
            e.printStackTrace();
        }
        String  xmlFull = xmlLines.stream().collect(Collectors.joining(""));

        Pattern onlyExpiry = Pattern.compile("(<ttl[\\S\\s]*?<\\/ttl>)");
        Matcher matcher = onlyExpiry.matcher(xmlFull);
        matcher.find();
        System.out.println(" Expiry ===> " + matcher.group(1));

    }
}
