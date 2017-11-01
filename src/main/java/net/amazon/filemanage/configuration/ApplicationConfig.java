package net.amazon.filemanage.configuration;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.S3ClientOptions;
import net.amazon.filemanage.application.Application;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackageClasses = Application.class,
        excludeFilters = @Filter({Controller.class, Configuration.class}))
public class ApplicationConfig {

    @Value("${aws_access_key_id}")
    private String awsId;

    @Value("${aws_secret_access_key}")
    private String awsKey;

    @Bean
    public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocations(new Resource[]{
            new ClassPathResource("/amazon.properties")

        });
        return ppc;
    }

    @Bean @Primary
    public AmazonS3 s3client() {
        AmazonS3 amazonS3Client = new AmazonS3Client(new BasicAWSCredentials(awsId, awsKey));
        return amazonS3Client;
    }
}
