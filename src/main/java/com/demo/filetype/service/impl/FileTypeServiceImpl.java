package com.demo.filetype.service.impl;

import com.demo.filetype.domain.FileType;
import com.demo.filetype.mapper.FileTypeMapper;
import com.demo.filetype.service.FileTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileTypeServiceImpl implements FileTypeService {
    @Autowired
    private FileTypeMapper fileTypeMapper;

    @Override
    public List<FileType> FileTypeInfo() {
        return fileTypeMapper.FileTypeInfo();
    }

    @Override
    public List<FileType> FileTypeInfoByTypeName(String type_name) {
        return fileTypeMapper.FileTypeInfoByTypeName(type_name);
    }

    @Override
    public Integer InsertFileType(FileType fileType) {
        return fileTypeMapper.InsertFileType(fileType);
    }

    @Override
    public Integer updateFileType(FileType fileType) {
        return fileTypeMapper.updateFileType(fileType);
    }

    @Override
    public Integer deleteFileType(Integer id) {
        return fileTypeMapper.deleteFileType(id);
    }
}
