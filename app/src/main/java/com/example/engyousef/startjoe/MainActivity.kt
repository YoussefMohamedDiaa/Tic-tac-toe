package com.example.engyousef.startjoe

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    protected  fun buClick(view:View){
        val buSelected = view as Button
        var cellID = 0
        when(buSelected.id){
            R.id.button1-> cellID=1
            R.id.button2-> cellID=2
            R.id.button3-> cellID=3
            R.id.button4-> cellID=4
            R.id.button5-> cellID=5
            R.id.button6-> cellID=6
            R.id.button7-> cellID=7
            R.id.button8-> cellID=8
            R.id.button9-> cellID=9
        }
        playGame(cellID, buSelected)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var Activeplayer=1
    fun playGame(CellID:Int, buSelected:Button){

        if(Activeplayer==1){
            buSelected.text="X"
            buSelected.setBackgroundColor(Color.GREEN)
            player1.add(CellID)
            Activeplayer=2
            AutoPlay()
        }else{
            buSelected.text="O"
            buSelected.setBackgroundColor(Color.BLUE)
            player2.add(CellID)
            Activeplayer=1
        }

        buSelected.isEnabled=false
        Checkwinner()
    }

    fun Checkwinner(){
        var winner =-1
        //row 1
        if(player1.contains(1)&&player1.contains(2)&&player1.contains(3)){
            winner=1
        }
        if(player2.contains(1)&&player2.contains(2)&&player2.contains(3)){
            winner=2
        }
        //row 2
        if(player1.contains(4)&&player1.contains(5)&&player1.contains(6)){
            winner=1
        }
        if(player2.contains(4)&&player2.contains(5)&&player2.contains(6)){
            winner=2
        }
        //row 3
        if(player1.contains(7)&&player1.contains(8)&&player1.contains(9)){
            winner=1
        }
        if(player2.contains(7)&&player2.contains(8)&&player2.contains(9)){
            winner=2
        }

        //col 1
        if(player1.contains(1)&&player1.contains(4)&&player1.contains(7)){
            winner=1
        }
        if(player2.contains(1)&&player2.contains(4)&&player2.contains(7)){
            winner=2
        }
        //col 2
        if(player1.contains(2)&&player1.contains(5)&&player1.contains(8)){
            winner=1
        }
        if(player2.contains(2)&&player2.contains(5)&&player2.contains(8)){
            winner=2
        }
        //col 3
        if(player1.contains(3)&&player1.contains(6)&&player1.contains(9)){
            winner=1
        }
        if(player2.contains(3)&&player2.contains(6)&&player2.contains(9)){
            winner=2
        }

        if(winner!=-1){
            if(winner==1){
               Toast.makeText(this,"Player 1 wins the game", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Player 2 wins the game", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun AutoPlay(){
        var emptyCells = ArrayList<Int>()
        for(cell in 1..9){
            if(!(player1.contains(cell)||player2.contains(cell))){
                emptyCells.add(cell)
            }
        }

        val r = Random()
        val randidx =r.nextInt(emptyCells.size-0)
        val cellid= emptyCells.get(randidx)
        var buSelected:Button?
        when(cellid){
            1->buSelected=button1
            2->buSelected=button2
            3->buSelected=button3
            4->buSelected=button4
            5->buSelected=button5
            6->buSelected=button6
            7->buSelected=button7
            8->buSelected=button8
            9->buSelected=button9
            else->buSelected=button1
        }

        playGame(cellid,buSelected)
    }

}
