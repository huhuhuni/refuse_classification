package com.huni.web;


import org.springframework.web.bind.annotation.RestController;

//@RestController
public class test {
    /*@Autowired
    DeptMapper deptMapper;

    @GetMapping("/test")
    public void test() {
         List<Dept> depts = deptMapper.selectList(null);
        for (Dept dept : depts) {
            System.out.println(dept);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("name","开发部");
        List<Dept> depts1 = deptMapper.selectByMap(map);
       // 分页插件
        Page<Dept> page = new Page<>(1,5);
        deptMapper.selectPage(page,null);
        page.getTotal();
        page.getSize();
        //删除
        int i = deptMapper.deleteById(9);
        deptMapper.deleteByMap(map);
        //deptMapper
        QueryWrapper<Dept> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.isNotNull("name").ge("age",12).like("name","%qwe");
        objectQueryWrapper.eq("name","huni");
        deptMapper.selectList(objectQueryWrapper);

    }*/
}