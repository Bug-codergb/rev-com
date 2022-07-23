import 'package:flutter/material.dart';

main(){
  runApp(MyApp());
}
class MyApp extends StatelessWidget{
  @override
  Widget build(BuildContext context) {
    return  MaterialApp(
        home:GBHomePage()
    );
  }
}
class GBHomePage extends StatelessWidget{
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar:AppBar(
            title: const Text("这是我的第一个flutter程序")
        ),
        body:GBContentPage()
    );
  }
}
class GBContentPage extends StatelessWidget{
  const GBContentPage({Key? key}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return const Center(
      child: Text(
        "今天是个好日子",
        textDirection:TextDirection.ltr,
        style: TextStyle(
            fontSize: 35,
            color: Colors.deepOrangeAccent
        ),
      ),
    );
  }
}