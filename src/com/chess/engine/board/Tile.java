package com.chess.engine.board;
import com.chess.engine.pieces.Piece;

public abstract class Tile {

    protected final int tileCoordinate;

    Tile(int tileCoordinate){
        this.tileCoordinate=tileCoordinate;
    }

    public abstract boolean isTileOccupied();
    public abstract Piece getPiece();


    public static final class EmptyTile extends Tile{
        EmptyTile(final int tileCoordinate){
            super(tileCoordinate);
        }
        @Override
        public boolean isTileOccupied(){
            return false;
        }
        @Override
        public Piece getPiece(){
            return null;
        }
    }

    public static final class OccupiedTile extends Tile{
        private final Piece pieceOnTile;
        OccupiedTile(int tileCoordinate, Piece pieceOnTile){
            super(tileCoordinate);
            this.pieceOnTile=pieceOnTile;
        }

        @Override
        public boolean isTileOccupied() {
            return true;
        }
        @Override
        public  Piece getPiece(){
            return this.pieceOnTile;
        }
    }
}
