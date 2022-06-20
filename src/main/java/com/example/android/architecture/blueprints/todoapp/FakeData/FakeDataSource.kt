package com.example.android.architecture.blueprints.todoapp.FakeData

import androidx.lifecycle.LiveData
import com.example.android.architecture.blueprints.todoapp.data.Result
import com.example.android.architecture.blueprints.todoapp.data.Result.Error
import com.example.android.architecture.blueprints.todoapp.data.Result.Success
import com.example.android.architecture.blueprints.todoapp.data.Task
import com.example.android.architecture.blueprints.todoapp.data.source.TasksDataSource


class FakeDataSource(var tasks: MutableList<Task>? = mutableListOf()) : TasksDataSource {

    override suspend fun getTasks(): Result<List<Task>> {
        tasks?.let { return Success(ArrayList(it)) }
        return Error(
            Exception("Tasks not found")
        )
    }


    override suspend fun deleteAllTasks() {
        tasks?.clear()
    }

    override suspend fun saveTask(task: Task) {
        tasks?.add(task)
    }


    override fun observeTasks(): LiveData<Result<List<Task>>> {
        TODO("Not yet implemented")
    }


    override suspend fun refreshTasks() {
    }

    override fun observeTask(taskId: String): LiveData<Result<Task>> {
        TODO("Not yet implemented")
    }

    override suspend fun getTask(taskId: String): Result<Task> {
        TODO("Not yet implemented")
    }

    override suspend fun refreshTask(taskId: String) {
    }


    override suspend fun completeTask(task: Task) {
    }

    override suspend fun completeTask(taskId: String) {
    }

    override suspend fun activateTask(task: Task) {
    }

    override suspend fun activateTask(taskId: String) {
    }

    override suspend fun clearCompletedTasks() {
    }

    override suspend fun deleteTask(taskId: String) {
    }


}
