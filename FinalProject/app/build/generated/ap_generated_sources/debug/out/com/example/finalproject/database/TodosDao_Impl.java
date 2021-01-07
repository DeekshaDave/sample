package com.example.finalproject.database;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TodosDao_Impl implements TodosDao {
  private final RoomDatabase __db;

  private final SharedSQLiteStatement __preparedStmtOfCreate;

  private final SharedSQLiteStatement __preparedStmtOfSave;

  private final SharedSQLiteStatement __preparedStmtOfDeleteContent;

  public TodosDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__preparedStmtOfCreate = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "INSERT INTO todos (task) VALUES (?)";
        return _query;
      }
    };
    this.__preparedStmtOfSave = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE todos SET task = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteContent = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM todos WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public void create(final String tasks) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfCreate.acquire();
    int _argIndex = 1;
    if (tasks == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, tasks);
    }
    __db.beginTransaction();
    try {
      _stmt.executeInsert();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfCreate.release(_stmt);
    }
  }

  @Override
  public void save(final String task, final int id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfSave.acquire();
    int _argIndex = 1;
    if (task == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, task);
    }
    _argIndex = 2;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfSave.release(_stmt);
    }
  }

  @Override
  public void deleteContent(final int id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteContent.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteContent.release(_stmt);
    }
  }

  @Override
  public Todos getTodos() {
    final String _sql = "SELECT * FROM todos";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTask = CursorUtil.getColumnIndexOrThrow(_cursor, "task");
      final Todos _result;
      if(_cursor.moveToFirst()) {
        _result = new Todos();
        _result.id = _cursor.getInt(_cursorIndexOfId);
        _result.task = _cursor.getString(_cursorIndexOfTask);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
