package com.example.listadetarefas

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import java.text.FieldPosition

//Verifica quando o usuario realizar um toque longo na tela
class ItemLongPressListener(context: Context, recyclerView: RecyclerView, val clickListener: ClickListener) : RecyclerView.OnItemTouchListener {

    //Verifica se está sendo realizado um toque curto ou longo
    private val gestureDetector: GestureDetector
    init {
        gestureDetector = GestureDetector(context, object : GestureDetector.SimpleOnGestureListener() {
            override fun onSingleTapUp(e: MotionEvent): Boolean { //pega o toque simples
                return true
            }

            override fun onLongPress(e: MotionEvent) { //pega o toque longo
                val child = recyclerView.findChildViewUnder(e.x,e.y)
                if(child != null && clickListener != null) {
                    clickListener.onLongClick(child, recyclerView.getChildAdapterPosition(child))
                }
            }
        })
    }

    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) { }

    //Quando houver um toque simples, verifica a posição e ativa a fun ONclick
    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        val child = rv.findChildViewUnder(e.x,e.y)
        if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)){
            clickListener.onClick(child, rv.getChildAdapterPosition(child))
        }
        return false
    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) { }

    interface ClickListener {
        fun onClick(view: View, position: Int)
        fun onLongClick(view: View, position: Int)
    }
}