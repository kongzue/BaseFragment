# BaseFragment
BaseFragment是一款为Fragment提供快速开发的框架模块，
如何更加优雅的编写代码是BaseActivity存在的主要目的，也是本代码诞生的原因。

## 1.0更新说明：
- 快速规范化完成流程：加载布局、加载数据以及设置事件

## 使用方法：
1) 将您的Fragment继承BaseFragment，重写三个方法initViews(view)、initDatas()以及setEvents()
2) 重写onCreateView方法并添加相应的执行顺序，完整代码如下所示
```
public class MainHomeFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_me, null);
        initViews(view);
        initDatas();
        setEvents();
        return view;
    }

    @Override
    public void initViews(View view) {
        //加载布局，范例: boxTitle = view.findViewById(R.id.box_title);
    }

    @Override
    public void initDatas() {
        //此方法可以使您在使用context时省去getActivity()的麻烦，现在只需要使用表达式me即可代替。
        //范例： startActivity(new Intent(me,MainActivity.class));
        setActivity(getActivity());   

    }

    @Override
    public void setEvents() {
        //此处设置事件、监听器等
    }
}

```

## 提示
还有不完善的地方正在完善，如有问题欢迎反馈

## 开源协议
```
   Copyright Kongzue BaseFragment

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```
