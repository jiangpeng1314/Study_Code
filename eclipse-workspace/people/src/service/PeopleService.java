package service;

import java.io.IOException;
import java.util.List;

import pojo.People;

public interface PeopleService {
	List<People> show() throws IOException;
}
