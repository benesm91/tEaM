package cz.zswi.testovaniLoader.mapper;

import java.util.List;

import cz.zswi.testovaniLoader.model.Data;
import cz.zswi.testovaniLoader.model.OutData;

/**
 * Rozhrani mapperu
 *
 */
public interface IMapper {
	
	public List<OutData> map(List<Data> resource);
}
