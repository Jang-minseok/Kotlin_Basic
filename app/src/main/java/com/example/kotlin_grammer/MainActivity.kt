package com.example.kotlin_grammer

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.kotlin_grammer.databinding.ActivityMainBinding

fun main(){

    // val 은 상수라서 값 변경이 되지 않음
    val myName : String = "hahahaha"

    // var 은 값을 변경할 수 있음
    var myPet : String = "고양이"

    myPet = "강아지"

    println("myName: $myName")
    println("myPet: $myPet")

    ///////////////////////////////////////////////////////

    var isDarkModeOn: Boolean = true

    if (isDarkModeOn == true){
        println("다크모드 입니다. $isDarkModeOn")
    }

    if (isDarkModeOn != true){
        println("다크모드가 아닙니다. $isDarkModeOn")
    }

    when(isDarkModeOn){
        true -> println("다크모드 ON")
        false -> println("다크모드 OFF")
    }

    ///////////////////////////////////////////////////////////

    var myName2 : String? = null

    if (myName2 != null) {
        println("myName2: $myName2 - 데이터 없음")
    } else{
        println("myName2: $myName2")
    }

    //val myUnwrappedName = if (myName2 == null) "이름없음" else myName2
    //val myUnwrappedName : String = myName2 ?: "이름없음"
    val otherName : String = myName2.let {
        it
    }?: "이름없음"

    //////////////////////////////////////////////////////////////

    // 값변경이 안되는 배열
    val friends =
        listOf("철수", "영희", "제임스")
    println(friends)

    // 값 변경이 가능한 배열
    val myFriends =
        mutableListOf("철수", "영희", "제임스")

    // arrayOf 나 mutablelistOf 로 만든 배열은 요소값 변경이 가능하다.
    myFriends[0] = "지미"
    println(myFriends)

    // name을 맴버변수로 가지는 펫 데이터 클래스
    data class Pet(val name: String){}

    val myDog = Pet("댕댕이")
    val myCat = Pet("개냥이")

    // 자료형이 펫인 배열
    val myPets = arrayOf<Pet>(myDog,myCat)

    // foreach 문으로 요소값 확인
    for (myPetItem in myPets) {
        println(myPetItem)
        println(myPetItem.name)
    }

    // kotlin 에서 foreach 문 인덱스 가져오기
    for ((petIndex, myPetItem) in myPets.withIndex()) {
        //프린트는 그냥 출력
        print("${petIndex} : ")
        //println은 출력하고 다음줄
        println("${myPetItem.name}")
        // 0 : 댕댕이
        // 1 : 개냥이
    }

    ///////////////////////////////////////////////////////////
    // mapOf 를 통해 키, 값의 맵을 만들 수 있다.

    val friendsAge = mapOf(Pair("철수", 20), Pair("영희", 27), Pair("제임스", 30), "존시나" to 40, "알몬드" to 50)

    println(friendsAge)
    println(friendsAge.map{ it.value })

    ////////////////////////////////////////////////////////////
}

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}