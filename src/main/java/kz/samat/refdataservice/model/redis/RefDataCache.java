package kz.samat.refdataservice.model.redis;

import kz.samat.refdataservice.model.RefDataEntity;
import kz.samat.refdataservice.model.RefDataType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;

@RedisHash("RefData")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefDataCache {

    @Id
    private RefDataType dataType;
    private List<RefDataEntity> refDataList;
}
