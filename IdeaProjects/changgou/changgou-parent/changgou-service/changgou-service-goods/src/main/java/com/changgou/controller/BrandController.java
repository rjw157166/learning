package com.changgou.controller;

import com.changgou.goods.pojo.Brand;
import com.changgou.service.BrandService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/brand")
@CrossOrigin //跨域
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping
    public Result findAll(){
        return new Result<List<Brand>>(true, StatusCode.OK,"查询成功",brandService.findAll());
    }

    @GetMapping(value = "/{id}")
    public Result findById(@PathVariable(value = "id")Integer id){
        return new Result<Brand>(true, StatusCode.OK,"查询成功",brandService.findById(id));
    }

    @PostMapping
    public Result add(@RequestBody Brand brand){
        brandService.add(brand);
        return new Result(true, StatusCode.OK,"添加成功");
    }

    @PutMapping(value = "/{id}")
    public Result update(@PathVariable(value = "id")Integer id,@RequestBody Brand brand){
        brand.setId(id);
        brandService.update(brand);
        return new Result(true, StatusCode.OK,"修改成功");
    }

    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable(value = "id")Integer id){
        brandService.delete(id);
        return new Result(true, StatusCode.OK,"删除成功");
    }

    @PostMapping(value = "/search")
    public Result<List<Brand>> findList(@RequestBody Brand brand){
        List<Brand> list = brandService.findList(brand);
        return new Result<List<Brand>>(true, StatusCode.OK,"查询成功",list);
    }

    @GetMapping(value = "/search/{page}/{size}")
    public Result<PageInfo<Brand>> findPage(@PathVariable(value = "page")Integer page,@PathVariable(value = "size")Integer size){
        PageInfo<Brand> pageInfo=brandService.findPage(page,size);
        return new Result<PageInfo<Brand>>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    @PostMapping(value = "/search/{page}/{size}")
    public Result<PageInfo<Brand>> findPage(@RequestBody Brand brand,@PathVariable(value = "page")Integer page,@PathVariable(value = "size")Integer size){
//        int a=10/0;
        PageInfo<Brand> pageInfo=brandService.findPage(brand,page,size);
        return new Result<PageInfo<Brand>>(true,StatusCode.OK,"查询成功",pageInfo);
    }
}
